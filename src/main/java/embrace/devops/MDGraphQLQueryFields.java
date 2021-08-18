package embrace.devops;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.values.OfValues;

public class MDGraphQLQueryFields {
	@Parameter
	@Expression(ExpressionSupport.SUPPORTED)
	@Optional(defaultValue = "id name board {id name} creator {name} ")
	private String Fields;
	
	public String getFields() {
		return Fields;
	}

	public void setFields(String Fields) {
		this.Fields = Fields;
	}


}
