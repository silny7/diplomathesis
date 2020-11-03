package silny7.uniba.sk.unity.variables;

public class ArrayRange  {

    private RangeElement lowerBound;
    private RangeElement upperBound;

    public ArrayRange(){}

    public ArrayRange(RangeElement lowerBound, RangeElement upperBound){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public RangeElement getLowerBound() { return lowerBound; }

    public void setLowerBound(RangeElement lowerBound) {
        this.lowerBound = lowerBound;
    }

    public RangeElement getUpperBound() { return upperBound; }

    public void setUpperBound(RangeElement upperBound) {
        this.upperBound = upperBound;
    }
}
