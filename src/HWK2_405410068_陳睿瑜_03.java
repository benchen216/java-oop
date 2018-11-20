
public class HWK2_405410068_陳睿瑜_03 {
    public static void main(String[] args){
        NutritionFacts.Builder waferBuilder = new NutritionFacts.Builder(100,3);
        NutritionFacts wafer = waferBuilder.build();

        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8).build();

        System.out.println(cocaCola);

        NutritionFacts sprite = new NutritionFacts.Builder(240,8).c(100).e(30).f(27).build();
        System.out.println(sprite);
    }
}
