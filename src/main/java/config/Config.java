package config;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath({"contract.properties", "contract.secret.properties"})
public interface Config {
    @Property("contract.address")
    String contractAddress();
}
