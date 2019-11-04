import java.util.*;



public class Main {
    private final static double MIN_SUPPORT_DEGREE = 0.2; // 支持度阈值
    private final static double MIN_CONFIDENCE = 0.7; // 置信度阈值

    private static List<SourceData> sourceDataList;
    private static Set<FrequentSet> allFrequentSetList;
    private static Set<FrequentSet> curFrequentSetList;
    private static List<RelationRule> relationRuleList;

    //主入口
    public static void main(String[] args){
        //读取源数据
        sourceDataList=SourceData.getSource();
        System.out.println("源数据如下：\n"+sourceDataList);
        //建立初始频繁集
        allFrequentSetList =new LinkedHashSet<FrequentSet>();
        curFrequentSetList =new LinkedHashSet<FrequentSet>();
        for(String good:SourceData.ALLGOODSET){
            FrequentSet fs=new FrequentSet();
            fs.setDataset(new LinkedHashSet<String>(){{
                add(good);
            }});
            if(calSupport(fs)==true){//计算支持度并判断是否满足支持度
                allFrequentSetList.add(fs);
                curFrequentSetList.add(fs);
            }
        }
        //迭代产生新的频繁集
        while(!curFrequentSetList.isEmpty())
            genNewFrequent();//产生新的一轮频繁集
        System.out.println("频繁集如下:\n"+allFrequentSetList);
        //产生关联规则
        genRelationRule();
        System.out.println("关联规则如下:\n"+relationRuleList);
    }

    //计算某个频繁集的支持度
    public static boolean calSupport(FrequentSet fs){
        int support_num=0;
        for(SourceData sd:sourceDataList){
            boolean flag=true;
            for(String good:fs.getDataset()){
                if(!sd.getDataset().contains(good)){
                    flag=false;
                }
            }
            if(flag==true)
                support_num++;
        }
        double support_degree=support_num/(sourceDataList.size()+0.0);
        fs.setSuppotnum(support_num);
        fs.setSuppotdgree(support_degree);
        if(support_degree>=MIN_SUPPORT_DEGREE)
            return true;
        else
            return false;
    }

    public static void genNewFrequent(){//链接产生新的频繁集
        Set<FrequentSet> newFrequentList=new LinkedHashSet<FrequentSet>();
        for(FrequentSet curfs1:curFrequentSetList){
            for(FrequentSet curfs2:curFrequentSetList){
                FrequentSet tmp=new FrequentSet();
                for(String s1:curfs1.getDataset()){
                    tmp.getDataset().add(s1);
                }
                for(String s2:curfs2.getDataset()){
                    tmp.getDataset().add(s2);
                }
                if(tmp.getDataset().size()==curfs1.getDataset().size()+1)
                    newFrequentList.add(tmp);
            }
        }
        curFrequentSetList.clear();
        for(FrequentSet fs:newFrequentList){
            if(calSupport(fs)){
                allFrequentSetList.add(fs);
                curFrequentSetList.add(fs);
            }
        }

    }
    public static void genRelationRule() {//产生关联规则
        relationRuleList=new ArrayList<RelationRule>();
        for(FrequentSet fs:allFrequentSetList){
            List<FrequentSet> subFrequentSet =genSubset(fs);//对于每个关联规则产生其子集
            for(FrequentSet sfs:subFrequentSet){
                double confidence_degree=fs.getSuppotnum()/(sfs.getSuppotnum()+0.00);
                if(confidence_degree<MIN_CONFIDENCE)
                    continue;
                FrequentSet backFrequentSet=expect(fs,sfs);//产生补集

                relationRuleList.add(new RelationRule(){{
                    setFrontset(sfs);
                    setBackset(backFrequentSet);
                    setConfidence(confidence_degree);
                    setFull(fs);
                }});
            }
        }

    }
    public static List<FrequentSet> genSubset(FrequentSet fs) {//根据频繁集求子集
        Set<String> s=fs.getDataset();
        List<String> ls=new ArrayList<String>();
        for(String good:s){
            ls.add(good);
        }
        List<FrequentSet> result = new ArrayList<>();
        //非空真子集
        for(int i=1;i<(int)(Math.pow(2, ls.size()))-1;i++)
        {

            String flag = "";
            int ii=i;
            do
            {
                flag += ""+ii%2;
                ii = ii/2;
            } while (ii>0);
            FrequentSet tmp=new FrequentSet();
            for(int j=flag.length()-1;j>=0;j--)
            {
                if(flag.charAt(j)=='1')
                {
                    tmp.getDataset().add(ls.get(j));
                }
            }
            result.add(tmp);
            calSupport(tmp);
        }
        return result;
    }

//求补集的函数
    public static FrequentSet expect(FrequentSet s1,FrequentSet s2) {
        FrequentSet result = new FrequentSet();

        for(String good1:s1.getDataset()) {
            boolean flag = true;
            for(String good2:s2.getDataset())
            {
                if(good2.equals(good1))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                result.getDataset().add(good1);
        }
        calSupport(result);
        return result;
    }
}
