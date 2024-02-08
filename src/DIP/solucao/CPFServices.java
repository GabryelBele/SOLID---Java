package DIP.solucao;

import DIP.solucao.interfaces.ICpfServices;

public class CPFServices implements ICpfServices {
	
    public boolean isValid(String cpf) {
        return cpf.length() == 11;
    }
}
