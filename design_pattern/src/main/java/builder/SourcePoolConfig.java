package builder;

/**
 * @author xuxiang
 */
public class SourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;


    private SourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    // some getters...

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        /**
         * Validate parameters.
         *
         * @return
         */
        public SourcePoolConfig build() {
            if (name == null || "".equals(name)) {
                throw new IllegalArgumentException("name must not be null or empty.");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle should not be bigger than maxTotal.");
            }
            if (minIdle > maxIdle) {
                throw new IllegalArgumentException("minIdle should not be bigger than maxIdle.");
            }
            return new SourcePoolConfig(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }
    }
}
