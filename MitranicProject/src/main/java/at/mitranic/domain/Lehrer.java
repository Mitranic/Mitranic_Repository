package at.mitranic.domain;

import at.mitranic.timetable.Ensure;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lehrer")
public class Lehrer extends Base {

    private static final long serialVersionUID = -6667520361999134030L;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lehrer")
    private Collection<Fach> fach;

    protected Lehrer() {
        // required for JPA
    }

    public Lehrer(String name, Date birthDate) {
        Ensure.notEmpty("name", name);
        Ensure.notNull("birthDate", birthDate);
        this.name = name;
        this.birthDate = (Date)birthDate.clone();
        this.fach = new ArrayList<Fach>();
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return (Date)birthDate.clone();
    }

    public void addFach(Fach subject) {
        fach.add(subject);
    }

    public Collection<Fach> getFach() {
        return Collections.unmodifiableCollection(fach);
    }
}
