package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 중복이냐 명확성을 따질때 명확성을 따른다.
 */

@Repository
public class ItemRepository {

	private static final Map<Long, Item> store = new HashMap<>();
	private static long sequence = 0L;

	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);
		return item;
	}

	public Item findById(Long id) {
		return store.get(id);
	}

	public List<Item> findAll() {
		return new ArrayList<>(store.values());
	}

	public void update(Long itemId, Item updateParams) {
		Item findItem = findById(itemId);
		findItem.setItemName(updateParams.getItemName());
		findItem.setPrice(updateParams.getPrice());
		findItem.setQuantity(updateParams.getQuantity());
	}

	public void clear() {
		store.clear();
	}

}
