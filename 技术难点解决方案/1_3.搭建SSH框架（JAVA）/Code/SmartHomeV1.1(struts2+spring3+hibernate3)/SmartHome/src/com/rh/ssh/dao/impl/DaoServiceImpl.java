package com.rh.ssh.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.rh.ssh.dao.DaoService;

public class DaoServiceImpl extends HibernateDaoSupport implements DaoService {

	@Override
	public void add(Object obj) throws Exception {
		getHibernateTemplate().save(obj);
	}

	@Override
	public void addAll(final List list) throws Exception {
		getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				for (Object obj : list) {
					session.save(obj);
				}
				return null;
			}
		});
	}

	@Override
	public void delete(Object obj) throws Exception {
		getHibernateTemplate().delete(obj);
	}

	@Override
	public void deleteAll(List list) throws Exception {
		getHibernateTemplate().deleteAll(list);
	}

	@Override
	public int executeHQL(final String hql) throws Exception {
		int result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.executeUpdate();
					}
				});
		return result;
	}

	@Override
	public int executeHQL(final String hql, final String param, final Object value) throws Exception {
		int result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (value instanceof Collection) {
							query.setParameterList(param, (Collection) value);
						} else {
							query.setParameter(param, value);
						}
						return query.executeUpdate();
					}
				});
		return result;
	}

	@Override
	public int executeHQL(final String hql, final Map<String, Object> param) throws Exception {
		int result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						for (Entry<String, Object> entry : param.entrySet()) {
							if (entry.getValue() instanceof Collection) {
								query.setParameterList(entry.getKey(), (Collection) entry.getValue());
							} else {
								query.setParameter(entry.getKey(), entry.getValue());
							}
						}
						return query.executeUpdate();
					}
				});
		return result;
	}

	@Override
	public List find(String hql) throws Exception {
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List find(final String hql, final String param, final Object value) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (value instanceof Collection) {
					query.setParameterList(param, (Collection) value);
				} else {
					query.setParameter(param, value);
				}
				return query.list();
			}

		});
		return list;
	}

	@Override
	public List find(final String hql, final Map<String, Object> param) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (Entry<String, Object> entry : param.entrySet()) {
					if (entry.getValue() instanceof Collection) {
						query.setParameterList(entry.getKey(), (Collection) entry.getValue());
					} else {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				return query.list();
			}
		});
		return list;
	}

	@Override
	public Object findFirst(String hql) throws Exception {
		List list = find(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Object findFirst(String hql, String param, Object value) throws Exception {
		List list = find(hql, param, value);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Object findFirst(String hql, Map<String, Object> param) throws Exception {
		List list = find(hql, param);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List findLimit(final String hql, final int first, final int max) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
		return list;
	}

	@Override
	public List findLimit(final String hql, final String param, final Object value, final int first, final int max) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (value instanceof Collection) {
					query.setParameterList(param, (Collection) value);
				} else {
					query.setParameter(param, value);
				}
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
		return list;
	}

	@Override
	public List findLimit(final String hql, final Map<String, Object> param, final int first, final int max) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (Entry<String, Object> entry : param.entrySet()) {
					if (entry.getValue() instanceof Collection) {
						query.setParameterList(entry.getKey(), (Collection) entry.getValue());
					} else {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
		return list;
	}

	@Override
	public Object findUnique(final String hql) throws Exception {
		Object obj = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				return query.uniqueResult();
			}
		});
		return obj;
	}

	@Override
	public Object findUnique(final String hql, final String param, final Object value) throws Exception {
		Object obj = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (value instanceof Collection) {
					query.setParameterList(param, (Collection) value);
				} else {
					query.setParameter(param, value);
				}
				return query.uniqueResult();
			}
		});
		return obj;
	}

	@Override
	public Object findUnique(final String hql, final Map<String, Object> param) throws Exception {
		Object obj = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (Entry<String, Object> entry : param.entrySet()) {
					if (entry.getValue() instanceof Collection) {
						query.setParameterList(entry.getKey(), (Collection) entry.getValue());
					} else {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				return query.uniqueResult();
			}
		});
		return obj;
	}

	@Override
	public Object get(Class entityClass, Serializable id) throws Exception {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public void merge(Object obj) throws Exception {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	@Override
	public void mergeAll(List list) throws Exception {
		getHibernateTemplate().saveOrUpdateAll(list);
	}

	@Override
	public void update(Object obj) throws Exception {
		getHibernateTemplate().update(obj);
	}

	@Override
	public void updateAll(final List list) throws Exception {
		getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				for (Object obj : list) {
					session.update(obj);
				}
				return null;
			}
		});
	}

	@Override
	public int executeSQL(final String sql) throws Exception {
		Integer result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						SQLQuery query = session.createSQLQuery(sql);
						return query.executeUpdate();
					}
				});
		return result;
	}

	@Override
	public int executeSQL(final String sql, final String param, final Object value) throws Exception {
		Integer result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						SQLQuery query = session.createSQLQuery(sql);
						if (value instanceof Collection) {
							query.setParameterList(param, (Collection) value);
						} else {
							query.setParameter(param, value);
						}
						return query.executeUpdate();
					}
				});
		return result;
	}

	@Override
	public int executeSQL(final String sql, final Map<String, Object> param) throws Exception {
		Integer result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						SQLQuery query = session.createSQLQuery(sql);
						for (Entry<String, Object> entry : param.entrySet()) {
							if (entry.getValue() instanceof Collection) {
								query.setParameterList(entry.getKey(), (Collection) entry.getValue());
							} else {
								query.setParameter(entry.getKey(), entry.getValue());
							}
						}
						return query.executeUpdate();
					}
				});
		return result;
	}

	@Override
	public List executeSQLQuery(final String sql) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		return list;
	}

	@Override
	public List executeSQLQuery(final String sql, final String param, final Object value) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				if (value instanceof Collection) {
					query.setParameterList(param, (Collection) value);
				} else {
					query.setParameter(param, value);
				}
				return query.list();
			}
		});
		return list;
	}

	@Override
	public List executeSQLQuery(final String sql, final Map<String, Object> param) throws Exception {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				for (Entry<String, Object> entry : param.entrySet()) {
					if (entry.getValue() instanceof Collection) {
						query.setParameterList(entry.getKey(), (Collection) entry.getValue());
					} else {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				return query.list();
			}
		});
		return list;
	}
}