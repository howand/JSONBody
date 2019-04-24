package json.body;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
public class JSONBody<T> {

	@JsonProperty("header")
	private HeaderData headerData;
	
	@JsonProperty("order_data")
	@Getter
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
