public class NutritionFacts {
    private final int a,b,c,d,e,f;

    public static class Builder{
        private final int a,b;
        private int c,d,e,f;

        public Builder (int a, int b){this.a=a;this.b=b;}
        public Builder c(int v){this.c = v;return this;}
        public Builder d(int v){this.d = v;return this;}
        public Builder e(int v){this.e = v;return this;}
        public Builder f(int v){this.f = v;return this;}

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }
    private NutritionFacts(Builder builder){
        a = builder.a;b = builder.b;c = builder.c;d = builder.d;f = builder.f;e = builder.e;
    }

}
