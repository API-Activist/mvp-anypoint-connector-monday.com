package embrace.devops;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;


@Xml(prefix="monday")
@Extension(name="monday.com")
@Configurations(MondayComConfiguration.class)
public class MondayComExtension {
	

}
