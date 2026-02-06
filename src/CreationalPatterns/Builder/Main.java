package CreationalPatterns.Builder;

class House {

    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarage;
    private boolean hasPool;
    private boolean hasGarden;

    private House(Builder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.hasGarage = builder.hasGarage;
        this.hasPool = builder.hasPool;
        this.hasGarden = builder.hasGarden;
    }

    public static class Builder {

        private String foundation;
        private String structure;
        private String roof;
        private boolean hasGarage;
        private boolean hasPool;
        private boolean hasGarden;

        public Builder(String foundation, String structure, String roof) {  // These are mandatory attributes for object creation
            this.foundation = foundation;
            this.structure = structure;
            this.roof = roof;
            this.hasGarage = false;
            this.hasPool = false;
            this.hasGarden = false;
        }

        public Builder hasGarden(boolean hasGarage){
            this.hasGarden = hasGarage;
            return this;
        }

        public Builder hasPool(boolean hasPool){
            this.hasPool = hasPool;
            return this;
        }

        public Builder hasGarage(boolean hasGarage){
            this.hasGarage = hasGarage;
            return this;
        }

        public House build(){
            return new House(this);
        }
    }
}

public class Main {
}




















