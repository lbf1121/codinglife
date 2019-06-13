package ej2;

public class NutritionFactsBuilder {
    private final int servingSize;//食用份量(ml)
    private final int servings;//每份含量（per container）
    private final int calories;//卡路里
    private final int fat;//脂肪
    private final int sodium;//钠
    private final int carbohydrate;//碳水化合物

    public static class Builder{
        private final int servingSize;//食用份量(ml)
        private final int servings;//每份含量（per container）

        //Optional parameters - initialized to default values
        private int calories = 0;//卡路里
        private int fat = 0;//脂肪
        private int sodium = 0;//钠
        private int carbohydrate = 0;//碳水化合物

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionFactsBuilder build(){
            return new NutritionFactsBuilder(this);
        }
    }

    private NutritionFactsBuilder(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args){
        NutritionFactsBuilder cocaCola = new NutritionFactsBuilder.Builder(340,12)
                                        .calories(34)
                                        .fat(8)
                                        .sodium(0)
                                        .carbohydrate(27)
                                        .build();
    }
}
