package testing;

import java.util.HashMap;

public class CropRatio {
	private int totalWeight = 0;
    private HashMap<String, Integer> crops = new HashMap<String, Integer>();

    public void add(String name, int cropWeight) throws NullPointerException{
        Integer currentCropWeight = crops.get(name);

        // had to move this up so total weight was calculation before total for crop
        totalWeight += cropWeight;
        
        // if no current value for crop, add it to the hashmap
        if (currentCropWeight == null) {
            crops.put(name, cropWeight);
        }else{ //if there is a current value, update with combined weight
        	cropWeight += currentCropWeight;
        	crops.replace(name, cropWeight);
        }     
    }

    public double proportion(String name) throws NullPointerException{
        int current=crops.get(name);
        //Had to cast the integer to get the double for division
        double prop = current/(double)totalWeight;

        return prop;
        
    }

    public static void main(String[] args) {

        try{
            CropRatio cropRatio = new CropRatio();

            cropRatio.add("Wheat", 4);
            cropRatio.add("Wheat", 5);
            cropRatio.add("Rice", 1);
            System.out.println("Fraction of wheat: " + cropRatio.proportion("Wheat"));
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }
}
