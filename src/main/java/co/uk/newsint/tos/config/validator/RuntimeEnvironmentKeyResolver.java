package co.uk.newsint.tos.config.validator;

public interface RuntimeEnvironmentKeyResolver {
    /**
     * Determine and return the runtime environment; if an implementation is
     * unable to determine the runtime environment, null can be returned to
     * indicate this.
     * @return String
     */
    public String resolveRuntimeEnvironmentKey();
}