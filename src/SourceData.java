import java.util.*;

public class SourceData {
    private Set<String> dataset;
    @Override
    public String toString() {
        return dataset+"\n";
    }
    public static Set<String> ALLGOODSET=new LinkedHashSet<String>(){
        {
            add("物品1");
            add("物品2");
            add("物品3");
            add("物品4");
            add("物品5");
            add("物品6");
        }
    };

    public Set<String> getDataset() {
        return dataset;
    }

    public void setDataset(Set<String> dataset) {
        this.dataset = dataset;
    }

    public static List<SourceData> getSource(){
        List<SourceData> sourceDataList;
        sourceDataList =new ArrayList<SourceData>();
        SourceData sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品2");
            add("物品5");
            add("物品6");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品4");
            add("物品6");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品3");
            add("物品4");
            add("物品5");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品2");
            add("物品4");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品3");
            add("物品5");
            add("物品6");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品3");
            add("物品4");
            add("物品6");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品3");
            add("物品5");
            add("物品6");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品3");
            add("物品4");
            add("物品5");
            add("物品6");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品2");
            add("物品4");
        }});

        sourceDataList.add(sd);
        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品3");
            add("物品5");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品2");
            add("物品5");
        }});
        sourceDataList.add(sd);

        sd=new SourceData();
        sd.setDataset(new LinkedHashSet<String>(){{
            add("物品1");
            add("物品2");
            add("物品4");
            add("物品6");
        }});
        sourceDataList.add(sd);
        return sourceDataList;
    }
}
