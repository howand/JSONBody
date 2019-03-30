package json.body;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class HeaderData {

	@JsonProperty("timestamp")
	private LocalDateTime timestamp;
	
	@JsonProperty("contains_errors")
	private Boolean containsErrors;
	
	@JsonProperty("contains_order_data")
	private Boolean containsOrderData;
}
