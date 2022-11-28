package net.manager.iym.repository;

public abstract class TeamRepositoryImpl implements TeamRepository{

    @Override
    public boolean existsByTeamName(String teamName) {
        return false;
    }
}
