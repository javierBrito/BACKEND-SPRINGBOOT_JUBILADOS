package ec.gob.educacion.service.resources;
import java.util.Comparator;

import org.joda.time.Interval;
public class ComparadorIntervalos implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.getStart().compareTo(o2.getStart());
	}

}
