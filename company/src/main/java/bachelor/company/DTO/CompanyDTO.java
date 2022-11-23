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
    private String barnchetekst;
    private int barnchekode;
    private List<Integer> penhederList;
    private List<Integer> bibrancheList;
    private int vejkode;
    private int postnummer;

}
