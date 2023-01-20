package strategy.framework.common;

import java.sql.Connection;

@FunctionalInterface
public interface ConnectionCreator {

	public Connection getConnection();
	
}
