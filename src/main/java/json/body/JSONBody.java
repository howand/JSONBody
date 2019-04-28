package json.body;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
public class JSONBody<T> {

	@JsonProperty("header")
	private HeaderData headerData;
	
	@JsonProperty("data")
	@Getter
	private T data;
	
	@JsonProperty("exception")
	private ExceptionInformation exceptionInformation;
	
	@Builder
	public JSONBody (T data, ExceptionInformation exceptionInformation) {
		this.headerData = HeaderData.builder().timestamp(LocalDateTime.now()).containsOrderData(data != null).containsErrors(exceptionInformation != null).build();
		this.data = data;
		this.exceptionInformation = exceptionInformation;
	}
}
