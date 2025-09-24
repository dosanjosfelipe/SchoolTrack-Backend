package app.vercel.schooltrack.repository;

import app.vercel.schooltrack.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<ClassRoom, String> {

}
