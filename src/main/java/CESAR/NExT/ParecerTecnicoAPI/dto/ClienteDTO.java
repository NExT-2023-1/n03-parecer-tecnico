package CESAR.NExT.ParecerTecnicoAPI.dto;
import CESAR.NExT.ParecerTecnicoAPI.entities.Cliente;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    
    @NotBlank
    @Size(min = 2, max = 100)
    private String nome;
    @NotBlank
    @Size(min = 2, max = 100)
    private String cpf;
    @NotNull
    @Min(0)
    private int telefone;

    public Cliente toEntity() {
        return Cliente.builder()
                .nome(this.nome)
                .cpf(this.cpf)
                .telefone(this.telefone)
                .build();
    }

    public Cliente toEntityUpdate(Cliente cliente) {
        return Cliente.builder()
                .id(cliente.getId())
                .nome(this.nome)
                .cpf(this.cpf)
                .telefone(this.telefone)
                .build();
    }
}
