package org.fao.geonet.repository.specification;

import org.fao.geonet.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.HashSet;

public final class UserGroupSpecs {

    private UserGroupSpecs() {
        // don't permit instantiation
    }

    public static Specification<UserGroup> hasGroupId(final int groupId) {
        return new Specification<UserGroup>() {
            @Override
            public Predicate toPredicate(Root<UserGroup> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Integer> grpIdAttributePath = root.get(UserGroup_.id).get(UserGroupId_.groupId);
                Predicate grpIdEqualPredicate = cb.equal(grpIdAttributePath, cb.literal(groupId));
                return grpIdEqualPredicate;
            }
        };
    }

    public static Specification<UserGroup> hasUserId(final int userId) {
        return new Specification<UserGroup>() {
            @Override
            public Predicate toPredicate(Root<UserGroup> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Integer> userIdAttributePath = root.get(UserGroup_.id).get(UserGroupId_.userId);
                Predicate userIdEqualPredicate = cb.equal(userIdAttributePath, cb.literal(userId));
                return userIdEqualPredicate;
            }
        };
    }

    public static Specification<UserGroup> hasProfile(final Profile profile) {
        return new Specification<UserGroup>() {
            @Override
            public Predicate toPredicate(Root<UserGroup> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Profile> userIdAttributePath = root.get(UserGroup_.id).get(UserGroupId_.profile);
                Predicate userIdEqualPredicate = cb.equal(userIdAttributePath, cb.literal(profile));
                return userIdEqualPredicate;
            }
        };
    }

    /**
     * Specification for testing if the UserGroup is (or is not) a reserved group.
     *
     * @param isReservedGroup true if the groups should be a reserved group.
     * @return Specification for testing if the UserGroup is (or is not) a reserved group.
     */
    public static Specification<UserGroup> isReservedGroup(final boolean isReservedGroup) {
        return new Specification<UserGroup>() {
            @Override
            public Predicate toPredicate(Root<UserGroup> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                HashSet<Integer> ids = new HashSet<Integer>();
                for (ReservedGroup reservedGroup : ReservedGroup.values()) {
                    ids.add(reservedGroup.getId());
                }

                Predicate inIdsPredicate = root.get(UserGroup_.group).get(Group_.id).in(ids);

                if (isReservedGroup) {
                    return inIdsPredicate;
                } else {
                    return inIdsPredicate.not();
                }
            }
        };
    }
}
