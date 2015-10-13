package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzbla on 13/10/2015.
 */
public class Region implements Comparable<Region>
{
    private int _id;
    private String _name;
    private int _order;
    private String _imagePath;

    public int getId() { return _id; }
    public void setId(int id) { _id = id; }

    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    public int getOrder() { return _order; }
    public void setOrder(int order) { _order = order; }

    public String getImagePath() { return _imagePath; }
    public void setImagePath(String path) { _imagePath = path; }

    public Region(int id, String name, int order, String imagePath)
    {
        _id = id;
        _name = name;
        _order = order;
        _imagePath = imagePath;
    }

    public static List<Region> GetRegionList()
    {
        List<Region> regions = new ArrayList<>();
        Region northland = new Region(1, "Northland", 1, "northland.png");
        Region auckland = new Region(2, "Auckland", 2, "auckland.png");
        Region waikato = new Region(3, "Waikato", 3, "waikato.png");
        Region bayOfPlenty = new Region(4, "Bay of Plenty", 4, "bayofplenty.png");
        Region gisborne = new Region(5, "Gisborne", 5, "gisborne.png");
        Region hawkesBay = new Region(6, "Hawkes Bay", 6, "hawkesbay.png");
        Region taranaki = new Region(7, "Taranaki", 7, "taranaki.png");
        Region manawatu = new Region(8, "Manawatu-Wanganui", 8, "manawatu.png");
        Region wellington = new Region(9, "Wellington", 9, "wellington.png");
        Region tasman = new Region(10, "Tasman", 10, "tasman.png");
        Region nelson = new Region(11, "Nelson", 11, "nelson.png");
        Region marlborough = new Region(12, "Marlborough", 12, "marlborough.png");
        Region westCoast = new Region(13, "West Coast", 13, "westcoast.png");
        Region canterbury = new Region(14, "Canterbury", 14, "canterbury.png");
        Region otago = new Region(15, "Otago", 15, "otago.png");
        Region southland = new Region(16, "Southland", 16, "southland.png");

        regions.add(northland);
        regions.add(auckland);
        regions.add(waikato);
        regions.add(bayOfPlenty);
        regions.add(gisborne);
        regions.add(hawkesBay);
        regions.add(taranaki);
        regions.add(manawatu);
        regions.add(wellington);
        regions.add(tasman);
        regions.add(nelson);
        regions.add(marlborough);
        regions.add(westCoast);
        regions.add(canterbury);
        regions.add(otago);
        regions.add(southland);

        return regions;
    }

    @Override
    public String toString() {
        return this.getName();            // What to display in the Spinner list.
    }

    @Override
    public int compareTo(Region reg) {
        return this.getOrder() < reg.getOrder() ? -1 : 1;
    }
}
