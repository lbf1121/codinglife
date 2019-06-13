package ej2;

public class NutritionFacts {

    private final int servingSize;//食用份量(ml)
    private final int servings;//每份含量（per container）
    private final int calories;//卡路里
    private final int fat;//脂肪
    private final int sodium;//钠
    private final int carbohydrate;//碳水化合物

    public NutritionFacts(int servingSize,int servings) {
        this(servingSize,servings,0);
    }

    public NutritionFacts(int servingSize,int servings,int calories) {
        this(servingSize,servings,calories,0);
    }

    public NutritionFacts(int servingSize,int servings,int calories,int fat) {
        this(servingSize,servings,calories,fat,0);
    }

    public NutritionFacts(int servingSize,int servings,int calories,int fat,int sodium) {
        this(servingSize,servings,calories,fat,sodium,0);
    }

    public NutritionFacts(int servingSize,int servings,int calories,int fat,int sodium,int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void mian(String[] args){
        NutritionFacts nutritionFacts = new NutritionFacts(240,8,100,0,35,27);
    }
}
