package helpers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.nasuapps.nzschools_android_.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import models.Directory;

/**
 * Created by xzbla on 17/10/2015.
 */
public class TaskHelper extends AsyncTask<String, Integer, Boolean> {
    private Context _context;
    private ProgressDialog _dialog;

    public TaskHelper(Context context)
    {
        _context = context;
        _dialog = new ProgressDialog(_context);
    }

    protected void onPreExecute() {
        _dialog.setTitle("Loading Schools...");
        _dialog.setMessage("This will only be done the first time");
        _dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        _dialog.setProgressNumberFormat(null);
        _dialog.setCancelable(false);
        if (!(_dialog.isShowing()))
            _dialog.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        DatabaseHelper db = new DatabaseHelper(_context);
        try {
            JSONArray json = new JSONArray(params[0]);

            _dialog.setProgressNumberFormat("%1d / %2d");
            _dialog.setProgress(0);
            _dialog.setMax(json.length());

            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = json.getJSONObject(i);

                Directory directory = new Directory(
                        jsonObject.getInt("Id"),
                        jsonObject.getInt("SchoolId"),
                        jsonObject.getString("Name"),
                        jsonObject.getString("Telephone"),
                        jsonObject.getString("Fax"),
                        jsonObject.getString("Email"),
                        jsonObject.getString("Principal"),
                        jsonObject.getString("SchoolWebsite"),
                        jsonObject.getString("Street"),
                        jsonObject.getString("Suburb"),
                        jsonObject.getString("City"),
                        jsonObject.getString("RegionalCouncil"),
                        jsonObject.getString("PostalAddress1"),
                        jsonObject.getString("PostalAddress2"),
                        jsonObject.getString("PostalAddress3"),
                        jsonObject.getString("PostalCode"),
                        jsonObject.getString("UrbanArea"),
                        jsonObject.getString("SchoolType"),
                        jsonObject.getString("Definition"),
                        jsonObject.getString("Authority"),
                        jsonObject.getString("GenderOfStudents"),
                        jsonObject.getString("TerritorialAuthorityWithAucklandLocalBoard"),
                        jsonObject.getString("MinistryOfEducationLocalOffice"),
                        jsonObject.getString("EducationRegion"),
                        jsonObject.getString("GeneralElectorate"),
                        jsonObject.getString("MāoriElectorate"),
                        jsonObject.getString("CensusAreaUnit"),
                        jsonObject.getString("Ward"),
                        jsonObject.getDouble("Latitude"),
                        jsonObject.getDouble("Longitude"),
                        jsonObject.getInt("Decile"),
                        jsonObject.getInt("TotalSchoolRoll"),
                        jsonObject.getInt("EuropeanPākehā"),
                        jsonObject.getInt("Māori"),
                        jsonObject.getInt("Pasifika"),
                        jsonObject.getInt("Asian"),
                        jsonObject.getInt("Melaa"),
                        jsonObject.getInt("Other"),
                        jsonObject.getInt("ChangeId"),
                        jsonObject.getBoolean("Status"));
                db.addDirectory(directory);
                publishProgress(i);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    protected void onProgressUpdate(Integer... progress) {
        if (_dialog.isShowing())
            _dialog.setProgress(progress[0]);
    }

    protected void onPostExecute(Boolean result) {
        _dialog.dismiss();
        ((MainActivity)_context).onTaskComplete();
    }
}
