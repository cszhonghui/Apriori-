import java.util.*;

public class RelationRule {
    FrequentSet frontset=new FrequentSet();
    FrequentSet backset=new FrequentSet();
    FrequentSet fullset=new FrequentSet();
    double confidence;

    public FrequentSet getFullset() {
        return fullset;
    }

    public void setFull(FrequentSet full) {
        this.fullset = full;
    }
    @Override
    public String toString() {
        return frontset.getDataset()+"==>"+backset.getDataset()+" 置信度为："+confidence+"\n"+
                "   "+fullset.getDataset()+":"+fullset.getSuppotnum()+"\n"+
                "   "+frontset.getDataset()+":"+frontset.getSuppotnum()+"\n";
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public FrequentSet getFrontset() {
        return frontset;
    }

    public void setFrontset(FrequentSet frontset) {
        this.frontset = frontset;
    }

    public FrequentSet getBackset() {
        return backset;
    }

    public void setBackset(FrequentSet backset) {
        this.backset = backset;
    }
}
