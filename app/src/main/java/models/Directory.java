package models;

import android.text.TextUtils;

/**
 * Created by xzbla on 13/10/2015.
 */
public class Directory implements Comparable
{
    private int _id;
    private int _schoolId;
    private String _name;
    private String _telephone;
    private String _fax;
    private String _email;
    private String _principal;
    private String _schoolWebsite;
    private String _street;
    private String _suburb;
    private String _city;
    private String _region;
    private String _postalAddress1;
    private String _postalAddress2;
    private String _postalAddress3;
    private String _postalCode;
    private String _urbanArea;
    private String _schoolType;
    private String _definition;
    private String _authority;
    private String _genderOfStudents;
    private String _territorialAuthorityWithAucklandLocalBoard;
    private String _ministryOfEducationLocalOffice;
    private String _educationRegion;
    private String _generalElectorate;
    private String _māoriElectorate;
    private String _censusAreaUnit;
    private String _ward;
    private Double _latitude;
    private Double _longitude;
    private int _decile;
    private int _totalSchoolRoll;
    private int _europeanPākehā;
    private int _māori;
    private int _pasifika;
    private int _asian;
    private int _melaa;
    private int _other;
    private int _changeId;
    private Boolean _status;

    public Directory(int id, int schoolId, String name,
                     String telephone, String fax, String email, String principal,
                     String schoolWebsite, String street, String suburb,
                     String city, String region, String postalAddress1, String postalAddress2,
                     String postalAddress3,String postalCode, String urbanArea, String schoolType,
                     String definition, String authority, String genderOfStudents,
                     String territorialAuthorityWithAucklandLocalBoard, String ministryOfEducationLocalOffice,
                     String educationRegion, String generalElectorate, String māoriElectorate,
                     String censusAreaUnit, String ward, Double latitude, Double longitude, int decile,
                     int totalSchoolRoll, int europeanPākehā, int māori, int pasifika, int asian,
                     int melaa, int other, int changeId, Boolean status) {
        _id = id;
        _schoolId = schoolId;
        _name = name;
        _telephone = telephone;
        _fax = fax;
        _email = email;
        _principal = principal;
        _schoolWebsite = schoolWebsite;
        _street = street;
        _suburb = suburb;
        _city = city;
        _region = region;
        _postalAddress1 = postalAddress1;
        _postalAddress2 = postalAddress2;
        _postalAddress3 = postalAddress3;
        _postalCode = postalCode;
        _urbanArea = urbanArea;
        _schoolType = schoolType;
        _definition = definition;
        _authority = authority;
        _genderOfStudents = genderOfStudents;
        _territorialAuthorityWithAucklandLocalBoard = territorialAuthorityWithAucklandLocalBoard;
        _ministryOfEducationLocalOffice = ministryOfEducationLocalOffice;
        _educationRegion = educationRegion;
        _generalElectorate = generalElectorate;
        _māoriElectorate = māoriElectorate;
        _censusAreaUnit = censusAreaUnit;
        _ward = ward;
        _latitude = latitude;
        _longitude = longitude;
        _decile = decile;
        _totalSchoolRoll = totalSchoolRoll;
        _europeanPākehā = europeanPākehā;
        _māori = māori;
        _pasifika = pasifika;
        _asian = asian;
        _melaa = melaa;
        _other = other;
        _changeId = changeId;
        _status = status;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getSchoolId() {
        return _schoolId;
    }

    public void setSchoolId(int schoolId) {
        _schoolId = schoolId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getStreet() {
        return _street;
    }

    public void setStreet(String street) {
        _street = street;
    }

    public String getSuburb() {
        return _suburb;
    }

    public void setSuburb(String suburb) {
        _suburb = suburb;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getTelephone()
    {
        return _telephone;
    }

    public void setTelephone(String telephone)
    {
        _telephone = telephone;
    }

    public String getFax()
    {
        return _fax;
    }

    public void setFax(String fax)
    {
        _fax = fax;
    }

    public String getEmail()
    {
        return _email;
    }

    public void setEmail(String email)
    {
        _email = email;
    }

    public String getPrincipal()
    {
        return _principal;
    }

    public void setPrincipal(String principal)
    {
        _principal = principal;
    }

    public String getSchoolWebsite()
    {
        return _schoolWebsite;
    }

    public void setSchoolWebsite(String schoolWebsite)
    {
        _schoolWebsite = schoolWebsite;
    }

    public String getRegion() {
        return _region;
    }

    public void setRegion(String region) {
        _region = region;
    }

    public String getPostalAddress1() {
        return _postalAddress1;
    }

    public void setPostalAddress1(String address) {
        _postalAddress1 = address;
    }

    public String getPostalAddress2() {
        return _postalAddress2;
    }

    public void setPostalAddress2(String address) {
        _postalAddress2 = address;
    }

    public String getPostalAddress3() {
        return _postalAddress3;
    }

    public void setPostalAddress3(String address) {
        _postalAddress3 = address;
    }

    public String getPostalCode() {
        return _postalCode;
    }

    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;
    }

    public String getUrbanArea() {
        return _urbanArea;
    }

    public void setUrbanArea(String urbanArea) {
        _urbanArea = urbanArea;
    }

    public String getSchoolType() {
        return _schoolType;
    }

    public void setSchoolType(String schoolType) {
        _schoolType = schoolType;
    }

    public String getDefinition() {
        return _definition;
    }

    public void setDefinition(String definition) {
        _definition = definition;
    }

    public String getAuthority() {
        return _authority;
    }

    public void setAuthority(String authority) {
        _authority = authority;
    }

    public String getGenderOfStudents() {
        return _genderOfStudents;
    }

    public void setGenderOfStudents(String gender) {
        _genderOfStudents = gender;
    }

    public String getTerritorialAuthorityWithAucklandLocalBoard() {
        return _territorialAuthorityWithAucklandLocalBoard;
    }

    public void setTerritorialAuthorityWithAucklandLocalBoard(String board) {
        _territorialAuthorityWithAucklandLocalBoard = board;
    }

    public String getMinistryOfEducationLocalOffice() {
        return _ministryOfEducationLocalOffice;
    }

    public void setMinistryOfEducationLocalOffice(String office) {
        _ministryOfEducationLocalOffice = office;
    }

    public String getEducationRegion() {
        return _educationRegion;
    }

    public void setEducationRegion(String educationRegion) {
        _educationRegion = educationRegion;
    }

    public String getGeneralElectorate() {
        return _generalElectorate;
    }

    public void setGeneralElectorate(String generalElectorate) {
        _generalElectorate = generalElectorate;
    }

    public String getMāoriElectorate() {
        return _māoriElectorate;
    }

    public void setMāoriElectorate(String māoriElectorate) {
        _māoriElectorate = māoriElectorate;
    }

    public String getCensusAreaUnit() {
        return _censusAreaUnit;
    }

    public void setCensusAreaUnit(String censusAreaUnit) {
        _censusAreaUnit = censusAreaUnit;
    }

    public String getWard() {
        return _ward;
    }

    public void setWard(String ward) {
        _ward = ward;
    }

    public Double getLatitude() {
        return _latitude;
    }

    public void setLatitude(Double latitude) {
        _latitude = latitude;
    }

    public Double getLongitude() {
        return _longitude;
    }

    public void setLongitude(Double longitude) {
        _longitude = longitude;
    }

    public int getDecile() {
        return _decile;
    }

    public void setDecile(int decile) {
        _decile = decile;
    }

    public int getTotalSchoolRoll() {
        return _totalSchoolRoll;
    }

    public void setTotalSchoolRoll(int totalSchoolRoll) {
        _totalSchoolRoll = totalSchoolRoll;
    }

    public int getEuropeanPākehā() {
        return _europeanPākehā;
    }

    public void setEuropeanPākehā(int europeanPākehā) {
        _europeanPākehā = europeanPākehā;
    }

    public int getMāori() {
        return _māori;
    }

    public void setMāori(int māori) {
        _māori = māori;
    }

    public int getPasifika() {
        return _pasifika;
    }

    public void setPasifika(int pasifika) {
        _pasifika = pasifika;
    }

    public int getAsian() {
        return _asian;
    }

    public void setAsian(int asian) {
        _asian = asian;
    }

    public int getMelaa() {
        return _melaa;
    }

    public void setMelaa(int melaa) {
        _melaa = melaa;
    }

    public int getOther() {
    return _other;
}

    public void setOther(int other) {
        _other = other;
    }

    public int getChangeId() {
        return _changeId;
    }

    public void setChangeId(int changeId) {
        _changeId = changeId;
    }

    public Boolean getStatus() {
        return _status;
    }

    public void setStatus(Boolean status) {
        _status = status;
    }

    public String getAddress() {
        String address = getStreet();

        if (!TextUtils.isEmpty(getSuburb()))
            address = address + ", " + getSuburb();

        address = address + ", " + getCity();
        return address;
    }

    @Override
    public int compareTo(Object another) {
        return getName().compareToIgnoreCase(((Directory)another).getName());
    }
}
