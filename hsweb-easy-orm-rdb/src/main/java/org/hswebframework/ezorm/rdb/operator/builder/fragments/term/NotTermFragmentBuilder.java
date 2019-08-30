package org.hswebframework.ezorm.rdb.operator.builder.fragments.term;

import org.hswebframework.ezorm.core.param.Term;
import org.hswebframework.ezorm.rdb.meta.RDBColumnMetadata;
import org.hswebframework.ezorm.rdb.operator.builder.fragments.PrepareSqlFragments;

public class NotTermFragmentBuilder extends AbstractTermFragmentBuilder {

    public NotTermFragmentBuilder(String termType, String name) {
        super(termType, name);
    }

    @Override
    public PrepareSqlFragments createFragments(String tableName, RDBColumnMetadata column, Term term) {

        // column != ?
        return PrepareSqlFragments.of()
                .addSql(getColumnFullName(tableName, column), "!= ?")
                .addParameter(convertValue(column, term));
    }
}