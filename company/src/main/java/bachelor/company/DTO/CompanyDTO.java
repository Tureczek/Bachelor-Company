package bachelor.company.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO implements Serializable {

    private String navn;
    private int cvr;
    private String hovedBarnchetekst;
    private int hovedBarnchekode;
    private List<Integer> penhederList;
    private List<String> bibrancheList;
    private int vejkode;
    private int postnummer;

}
