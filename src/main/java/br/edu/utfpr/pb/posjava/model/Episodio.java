package br.edu.utfpr.pb.posjava.model;

import br.edu.utfpr.pb.posjava.util.BooleanConverter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "episodio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Episodio implements AbstractModel<Long>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 254, nullable = false)
    private String nome;

    @Column(length = 1000, nullable = false)
    private String resumo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataExibicao;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private int temporada;

    @NotNull(message = "O campo nota deve ser informado.")
    @Column(nullable = false)
    private BigDecimal nota;

    @NotNull(message = "A série deverá ser selecionada.")
    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false, referencedColumnName = "id")
    private Serie serie;

    @Convert(converter = BooleanConverter.class)
    @Column(columnDefinition = "char(1) default 'V'")
    private Boolean ativo;
}
