package ultilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Config.Sources({"file:environmentConfig/${environment}.properties"})
public interface EnvironmentConfig extends Config {
    @Key("App.Url")
    String getAppUrl();
    @Key("App.User")
    String getAppUsername();
    @Key("App.Pass")
    String getAppPassword();

}
