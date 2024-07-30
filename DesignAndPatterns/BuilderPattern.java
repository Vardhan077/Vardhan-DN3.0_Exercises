public class BuilderPattern {
    static class Computer {
        private String cpu;
        private String ram;
        private String storage;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
        }

        public String getCpu() {
            return cpu;
        }

        public String getRam() {
            return ram;
        }

        public String getStorage() {
            return storage;
        }

        public static class Builder {
            private String cpu;
            private String ram;
            private String storage;

            public Builder setCpu(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRam(String ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer gamingPc = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .build();
        System.out.println("CPU: " + gamingPc.getCpu());
        System.out.println("RAM: " + gamingPc.getRam());
        System.out.println("Storage: " + gamingPc.getStorage());
    }
}
