package beyondtoday.JSONBody;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;

@JsonInclude(Include.NON_NULL)
public class JSONBody<T> {

	@JsonProperty("header")
	private HeaderData headerData;
	
	@JsonProperty("order_data")
	private T order;
	
	@JsonProperty("exception")
	private ExceptionInformation exceptionInformation;
	
	@Builder
	public JSONBody (T orders, ExceptionInformation exceptionInformation) {
		this.headerData = HeaderData.builder().timestamp(LocalDateTime.now()).containsOrderData(orders != null).containsErrors(exceptionInformation != null).build();
		this.order = orders;
		this.exceptionInformation = exceptionInformation;
	}
}
