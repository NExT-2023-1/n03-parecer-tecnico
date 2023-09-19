package CESAR.NExT.ParecerTecnicoAPI.dto;

import CESAR.NExT.ParecerTecnicoAPI.entities.Cliente;
import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ParecerTecnicoDTO {
    
    @NotBlank
    @Size(min = 2, max = 100)
    private String parecer;
    @NotBlank
    @Size(min = 2, max = 100)
    private Defeito defeito;
    @NotBlank
    @Size(min = 2, max = 100)
    private Cliente cliente;
    @NotBlank
    @Size(min = 2, max = 100)
    private Equipamento equipamento;

        public ParecerTecnico toEntity() {
            return ParecerTecnico.builder();
                .parecer(this.parecer)
                .defeito.(this.defeito)
                .cliente.(this.cliente)
                .equipamento.(this.equipamento)
                .build();
        }
        public ParecerTecnico toEntityUpdate() {
            return ParecerTecnico.builder();
                .id(parecer.getId())
                .parecer(this.parecer)
                .defeito.(this.defeito)
                .cliente.(this.cliente)
                .equipamento.(this.equipamento)
                .build();
    
    }
}
