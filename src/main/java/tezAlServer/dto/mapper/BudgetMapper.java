package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Budget;
import tezAlServer.dto.model.BudgetDto;

import java.util.List;

@Mapper
public interface BudgetMapper {

        BudgetDto toBudgetDto(Budget budget);

        List<BudgetDto> toBudgetDtos(List<Budget> budgets);

        Budget toBudget(BudgetDto budgetDto);
}
