import java.util.*;
import java.util.Set;

public class FrequentSet {
    private Set<String> dataset=new TreeSet<String>();
    private int suppotnum=0;
    private double suppotdgree=0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrequentSet that = (FrequentSet) o;
        boolean flag=true;
        if(dataset.size()!=that.dataset.size())
            flag=false;
        for(String s:dataset){
            if(!that.dataset.contains(s))
                flag=false;
        }
        return suppotnum == that.suppotnum &&
                Double.compare(that.suppotdgree, suppotdgree) == 0 &&
                flag;

    }

    @Override
    public int hashCode() {

        return Objects.hash(dataset, suppotnum, suppotdgree);
    }

    @Override
    public String toString() {
        return dataset+",支持数："+suppotnum+",支持度："+suppotdgree+"\n";
    }

    public int getSuppotnum() {
        return suppotnum;
    }

    public void setSuppotnum(int suppotnum) {
        this.suppotnum = suppotnum;
    }

    public double getSuppotdgree() {
        return suppotdgree;
    }

    public void setSuppotdgree(double suppotdgree) {
        this.suppotdgree = suppotdgree;
    }

    public Set<String> getDataset() {
        return dataset;
    }

    public void setDataset(Set<String> dataset) {
        this.dataset = dataset;
    }
}
