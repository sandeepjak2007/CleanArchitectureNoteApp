package code.sandeep.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import code.sandeep.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import code.sandeep.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import code.sandeep.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import code.sandeep.cleanarchitecturenoteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            GetNotesUseCase(repository),
            DeleteNoteUseCase(repository),
            AddNoteUseCase(repository),
            GetNoteUseCase(repository)
        )
    }
}