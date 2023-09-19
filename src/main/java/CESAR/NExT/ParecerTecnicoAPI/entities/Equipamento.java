package CESAR.NExT.ParecerTecnicoAPI.entities;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String defeito;
    @Column(nullable = false)
    private String parecer;
    @JoinColumn(name = "parecerTecnico_id", nullable = false)
    @JsonBackReference
    @OneToOne
    private ParecerTecnico parecerTecnico;
}
