package jp.co.solidcom.app.list;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ListColumnService {

	@Autowired
	ListColumnRepository repository;

	public List<ListColumn> findAll() {
		return repository.findList();
	}
	
	public Optional<ListColumn> findOne(Integer id) {
		return repository.findById(id);
	}
}
