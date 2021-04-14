package unityToJava.unity.variables;

import unityToJava.unity.exceptions.ProgramRunException;

public class ArrayRange  {

    private RangeElement lowerBound;
    private RangeElement upperBound;

    public ArrayRange(){}

    public ArrayRange(RangeElement lowerBound, RangeElement upperBound){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Integer getArrayLength() throws ProgramRunException {
        return upperBound.evaluate() - lowerBound.evaluate() + 1;
    }

    public RangeElement getLowerBound() { return lowerBound; }

    public void setLowerBound(RangeElement lowerBound) {
        this.lowerBound = lowerBound;
    }

    public RangeElement getUpperBound() { return upperBound; }

    public void setUpperBound(RangeElement upperBound) {
        this.upperBound = upperBound;
    }

    public String toString(){
        return lowerBound.toString() + ".." + upperBound.toString();
    }
}
