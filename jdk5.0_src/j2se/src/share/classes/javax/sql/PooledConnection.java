/*
 * @(#)PooledConnection.java	1.12 03/12/19
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * An object that provides hooks for connection pool management.  
 * A <code>PooledConnection</code> object
 * represents a physical connection to a data source.  The connection
 * can be recycled rather than being closed when an application is
 * finished with it, thus reducing the number of connections that
 * need to be made.
 * <P>
 * An application programmer does not use the <code>PooledConnection</code>
 * interface directly; rather, it is used by a middle tier infrastructure
 * that manages the pooling of connections.
 * <P>
 * When an application calls the method <code>DataSource.getConnection</code>,
 * it gets back a <code>Connection</code> object.  If connection pooling is
 * being done, that <code>Connection</code> object is actually a handle to
 * a <code>PooledConnection</code> object, which is a physical connection.
 * <P>
 * The connection pool manager, typically the application server, maintains
 * a pool of <code>PooledConnection</code> objects.  If there is a
 * <code>PooledConnection</code> object available in the pool, the
 * connection pool manager returns a <code>Connection</code> object that
 * is a handle to that physical connection.
 * If no <code>PooledConnection</code> object is available, the 
 * connection pool manager calls the <code>PooledConnection</code>
 * method <code>getConnection</code> to create a new physical connection and
 * returns a handle to it.
 * <P>
 * When an application closes a connection, it calls the <code>Connection</code>
 * method <code>close</code>. When connection pooling is being done,
 * the connection pool manager is notified because it has registered itself as
 * a <code>ConnectionEventListener</code> object using the 
 * <code>ConnectionPool</code> method <code>addConnectionEventListener</code>.
 * The connection pool manager deactivates the handle to
 * the <code>PooledConnection</code> object and  returns the 
 * <code>PooledConnection</code> object to the pool of connections so that
 * it can be used again.  Thus, when an application closes its connection,
 * the underlying physical connection is recycled rather than being closed.
 * <P>
 * The physical connection is not closed until the connection pool manager
 * calls the <code>PooledConnection</code> method <code>close</code>.
 * This method is generally called to have an orderly shutdown of the server or
 * if a fatal error has made the connection unusable.
 *
 * @since 1.4 
 */

public interface PooledConnection {

  /**
   * Creates and returns a <code>Connection</code> object that is a handle
   * for the physical connection that
   * this <code>PooledConnection</code> object represents.
   * The connection pool manager calls this method when an application has
   * called the method <code>DataSource.getConnection</code> and there are
   * no <code>PooledConnection</code> objects available. See the
   * {@link PooledConnection interface description} for more information.
   *
   * @return  a <code>Connection</code> object that is a handle to
   *          this <code>PooledConnection</code> object
   * @exception SQLException if a database access error occurs
   */
  Connection getConnection() throws SQLException;

  /**
   * Closes the physical connection that this <code>PooledConnection</code>
   * object represents.  An application never calls this method directly;
   * it is called by the connection pool module, or manager.
   * <P>
   * See the {@link PooledConnection interface description} for more 
   * information.
   *
   * @exception SQLException if a database access error occurs
   */
  void close() throws SQLException;
      
  /**
   * Registers the given event listener so that it will be notified
   * when an event occurs on this <code>PooledConnection</code> object.
   *
   * @param listener a component, usually the connection pool manager,
   *        that has implemented the
   *        <code>ConnectionEventListener</code> interface and wants to be
   *        notified when the connection is closed or has an error
   * @see #removeConnectionEventListener
   */
  void addConnectionEventListener(ConnectionEventListener listener);

  /**
   * Removes the given event listener from the list of components that
   * will be notified when an event occurs on this
   * <code>PooledConnection</code> object.
   *
   * @param listener a component, usually the connection pool manager,
   *        that has implemented the
   *        <code>ConnectionEventListener</code> interface and 
   *        been registered with this <code>PooledConnection</code> object as 
   *        a listener
   * @see #addConnectionEventListener
   */
  void removeConnectionEventListener(ConnectionEventListener listener);

 } 