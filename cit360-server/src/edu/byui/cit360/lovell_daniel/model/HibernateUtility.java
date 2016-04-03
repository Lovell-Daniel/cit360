package edu.byui.cit360.lovell_daniel.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtility {
	//Bill Pugh thread safe singleton pattern
	
	private HibernateUtility() {
		//prevents unwanted instantiation
	};

	private static class Singleton {
		private static final StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().build();
		private static final Metadata metadata = new MetadataSources(standardRegistry).buildMetadata();
		private static final SessionFactory FACTORY = metadata.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return Singleton.FACTORY;
	}
	
}


/*
public class HibernateUtility {
	//Synchronized Thread Safe Singleton
 
    public static SessionFactory factory;
 
    private HibernateUtility() {
		//prevents unwanted instantiation
    }
    
    public static synchronized SessionFactory getSessionFactory() {
 
        if (factory == null) {
			private static final StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().build();
			private static final Metadata metadata = new MetadataSources(standardRegistry).buildMetadata();
			private static final SessionFactory factory = metadata.buildSessionFactory();
        }
        return factory;
    }
}
*/