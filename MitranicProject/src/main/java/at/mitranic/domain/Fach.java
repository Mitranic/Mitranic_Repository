package at.mitranic.domain;

import at.mitranic.timetable.Ensure;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fach")
public class Fach extends Base {

	private static final long serialVersionUID = 1127398350055088704L;

	@Size(max = 255)
	@NotNull
	@Column(name = "name", nullable = false, length = 255)
	private String name;

    private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Lehrer> lehrer;


	protected Fach() {
		// required for JPA
	}

	public Fach(String name, String description) {
        Ensure.notNull("name", name);
		this.name = name;
        this.description = description;
        this.lehrer = new ArrayList<Lehrer>();
        
	}

	public String getName() {
		return name;
	}

    public String getDescription() {
        return description;
    }

	public void addLehrer(Lehrer teacher) {
		lehrer.add(teacher);
	}

	public Collection<Lehrer> getLehrer() {
		return Collections.unmodifiableCollection(lehrer);
	}
}
