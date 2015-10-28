package com.mtjwy.website.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.Item;
import com.mtjwy.website.exception.RssException;
import com.mtjwy.website.rss.ObjectFactory;
import com.mtjwy.website.rss.TRss;
import com.mtjwy.website.rss.TRssChannel;
import com.mtjwy.website.rss.TRssItem;



@Service
public class RssService {
	
	public List<Item> getItems(File file) throws RssException {
		return getItems(new StreamSource(file));
	}
	
	public List<Item> getItems(String url) throws RssException {
		return getItems(new StreamSource(url));
	}
	
	public List<Item> getItems(Source source) throws RssException{
		
		List<Item> list = new ArrayList<Item>();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
			TRss rss = jaxbElement.getValue();
			
			List<TRssChannel> channels = rss.getChannel();
			
			for (TRssChannel channel : channels) {
				List<TRssItem> items = channel.getItem();
				
				for (TRssItem tRssItem : items) {
					Item item = new Item();
					item.setTitle(tRssItem.getTitle());
					item.setDescription(tRssItem.getDescription());
					item.setLink(tRssItem.getLink());
					Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH).parse(tRssItem.getPubDate());
					item.setPublishDate(pubDate);
					
					list.add(item);
				}
			}
		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			throw new RssException(e);
		}
		
		return list;
	}
}
