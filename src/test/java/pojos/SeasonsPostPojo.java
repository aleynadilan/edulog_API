package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonsPostPojo {
    /*
    {
  "isActive": true,
  "name": "Dila"
  }
     */

    private boolean isActive;
    private String name;

}
