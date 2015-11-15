package service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.NotFoundException;

import entity.Quote;

@Api(name="quoteapi",version="v1", description="An API to manage famous quotes")
public class QuoteService {

	public static List<Quote> quotes = new ArrayList<Quote>();
	
	@ApiMethod(name="add")
	public Quote addQuote(@Named("id") Long  id, @Named("author") String author,@Named("message") String message) throws Exception {
		//Check for already exists
		int index = quotes.indexOf(new Quote(id));
		if (index != -1) throw new Exception("Quote Record already exists");
		Quote q = new Quote(id, author, message);
		quotes.add(q);
		return q;
	}
	
	@ApiMethod(name="update")
	public Quote updateQuote(Quote q) throws NotFoundException {
		int index = quotes.indexOf(q);
		if (index == -1) throw new NotFoundException("Quote Record does not exist");
		Quote currentQuote = quotes.get(index);
		currentQuote.setAuthor(q.getAuthor());
		currentQuote.setMessage(q.getMessage());
		return q;
	}
	
	@ApiMethod(name="remove")
	public void removeQuote(@Named("id") Long  id) throws NotFoundException  {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new NotFoundException ("Quote Record does not exist");
		quotes.remove(index);
	}
	
	@ApiMethod(name="list")
	public List<Quote> getQuotes() {
		return quotes;
	}
	
	@ApiMethod(name="listByAuthor")
	public List<Quote> getQuotesByAuthor(@Named("author") String author) {
		List<Quote> results = new ArrayList<Quote>();
		for (Quote quote : quotes) {
			if (quote.getAuthor().indexOf(author) != -1) {
				results.add(quote);
			}
		}
		return results;
	}
	
	@ApiMethod(name="getQuote")
	public Quote getQuote(@Named("id") Long  id) throws NotFoundException {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new NotFoundException("Quote Record does not exist");
		return quotes.get(index);
	}

}