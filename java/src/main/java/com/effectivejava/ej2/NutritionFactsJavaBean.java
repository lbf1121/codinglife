package com.effectivejava.ej2;

public class NutritionFactsJavaBean {
    private int servingSize;//食用份量(ml)
    private int servings;//每份含量（per container）
    private int calories;//卡路里
    private int fat;//脂肪
    private int sodium;//钠
    private int carbohydrate;//碳水化合物

    public NutritionFactsJavaBean() {}

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args){
        NutritionFactsJavaBean nutritionFacts = new NutritionFactsJavaBean();
        nutritionFacts.setServingSize(240);
        nutritionFacts.setServings(32);
        nutritionFacts.setCalories(34);
        nutritionFacts.setFat(0);
        nutritionFacts.setSodium(23);
        nutritionFacts.setCarbohydrate(123);
    }
}
