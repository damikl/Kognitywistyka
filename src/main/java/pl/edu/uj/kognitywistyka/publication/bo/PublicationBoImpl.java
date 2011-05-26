package pl.edu.uj.kognitywistyka.publication.bo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pl.edu.uj.kognitywistyka.publication.dao.PublicationDao;
import pl.edu.uj.kognitywistyka.publication.model.Publication;

public class PublicationBoImpl implements PublicationBo, Serializable {
	
	private static final long serialVersionUID = 1L;

	private PublicationDao publicationDao;

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

	public List<Publication> findAllPublication() {
		//return publicationDao.findAllPublication();

		//generowanie przykladowych danych
		List<Publication> publicationList = new ArrayList<Publication>();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		for (int i = 1; i <= 25; ++i) {
			Publication p = new Publication();
			p.setPublicationId(i);
			p.setTitle(i + "-title");
			p.setAuthorFirstName("Jan");
			p.setAuthorLastName("Kowalski");
			p.setDescription("opis");
			p.setFileName("plik.pdf");
			
			try {
				p.setDate(df.parse("12-03-2010"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			publicationList.add(p);
		}

		return publicationList;
	}

	public Publication getPublication(long id) {
		return publicationDao.getPublication(id);
	}

}
