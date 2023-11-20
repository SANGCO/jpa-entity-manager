package persistence.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persistence.DatabaseTestBase;

import static org.assertj.core.api.Assertions.assertThat;


class EntityEntriesTest extends DatabaseTestBase {

    @Test
    @DisplayName("addOrChange() 메서드 테스트")
    void addOrChange() {
        EntityEntries entityEntries = new EntityEntries();
        Status status = Status.MANAGED;
        Person person = entityManager.find(Person.class, 1L);

        entityEntries.addOrChange(person, status);

        assertThat(entityEntries.entityEntries).hasSize(1);
        assertThat(entityEntries.entityEntries.get(person).getStatus()).isEqualTo(status);
    }

}