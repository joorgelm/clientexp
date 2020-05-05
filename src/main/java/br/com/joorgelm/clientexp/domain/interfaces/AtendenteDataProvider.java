package br.com.joorgelm.clientexp.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.joorgelm.clientexp.domain.entity.Atendente;


public interface AtendenteDataProvider extends JpaRepository<Atendente, String> {

}
